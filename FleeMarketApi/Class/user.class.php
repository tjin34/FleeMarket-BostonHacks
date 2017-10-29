<?php


require_once dirname(__FILE__) . '/' . 'db.class.php';
require_once dirname(__FILE__) . '/' . 'json.class.php';
require_once dirname(__FILE__) . '/' . 'define.ini.php';



class User{

    var $time;
    var $db;
    var $json;

    function __construct() {
        $this->model();
    }

    function model() {
        $this->time = time();
        $this->db = new DB();
        $this->json = new JSON();
    }

    function register($username, $password) {
        if (!$username || !$password) {
            $json_array = array(
                'success' => false,
                'error' => 'EMPTY INPUTS!'
            );
        } else {
            $checkUsername = $this->db->fetch_all("SELECT * FROM ".DB_PRE."market_member WHERE username = '$username'");
            if ($checkUsername) {
                $json_array = array(
                    'success' => false,
                    'error' => 'USERNAME ALREADY EXISTED!'
                );
            } else {
                $salt = substr(uniqid(rand()), -6);
                $password = md5(md5($password).$salt);
                $this->db->query("INSERT INTO ".DB_PRE."market_member SET username = '$username', password = '$password', salt = '$salt'");
                $uid = $this->db->insert_id();
                if ($uid) {
                    $json_array = array(
                        'success' => true,
                        'error' => ''
                    );
                } else {
                    $json_array = array(
                        'success' => false,
                        'error' => 'ERROR CREATING USER!'
                    );
                }
            }
        }

        $json_string = $this->json->jsonFormat($json_array);
        $json_string = preg_replace("#\\\u([0-9a-f]{4})#ie", "iconv('UCS-2BE', 'UTF-8', pack('H4', '\\1'))", $json_string);
        echo stripslashes($json_string);
    }

    function login($username, $password) {
        $passwordCheck = $this->db->fetch_all("SELECT * FROM ".DB_PRE."market_member WHERE username = '$username'");
        $expiretime = $this->time + 30*24*3600;
        $token = md5($passwordCheck[0]['password'].time()).md5($passwordCheck[0]['uid'].time());
        $salt = $passwordCheck[0]['salt'];
        $password = md5(md5($password).$salt);
        if ($password == $passwordCheck[0]['password']) {
            $this->db->query("UPDATE ".DB_PRE."market_member SET token = '$token', expiretime = '$expiretime' WHERE username = '$username' ");
            $passwordCheck[0]['token'] = $token;
            $json_array = array(
                'data' => $passwordCheck[0],
                'success' => true,
                'error' => ''
            );
        } else {
            $json_array = array(
                'data' => array(),
                'success' => false,
                'error' => 'ERROR CREATING USER!'
            );
        }
        $json_string = $this->json->jsonFormat($json_array);
        $json_string = preg_replace("#\\\u([0-9a-f]{4})#ie", "iconv('UCS-2BE', 'UTF-8', pack('H4', '\\1'))", $json_string);
        echo stripslashes($json_string);
    }

    function getUserInfo($uid, $token) {
        $verify = $this->verify($uid, $token);
        if ($verify['success'] == true) {
            $userInfo = $this->db->fetch_all("SELECT * FROM ".DB_PRE."market_member WHERE uid = '$uid'");
            $json_array = array(
                'data' => $userInfo[0],
                'success' => true,
                'error' => ''
            );
        } else {
            $json_array = array(
                'data' => array(),
                'success' => false,
                'error' => $verify['error']
            );
        }
        $json_string = $this->json->jsonFormat($json_array);
        $json_string = preg_replace("#\\\u([0-9a-f]{4})#ie", "iconv('UCS-2BE', 'UTF-8', pack('H4', '\\1'))", $json_string);
        echo stripslashes($json_string);
    }

    function verify($uid, $token) {
        if (!empty($uid) && !empty($token)) {
            $sql = "SELECT token, expiretime FROM `".DB_PRE."market_member` WHERE uid = '$uid'";
            $sescheck = $this->db->fetch_all($sql);
            if(count($sescheck)==1){
                if ($token == $sescheck[0]['token']) {
                    if ($this->time >= $sescheck[0]['expiretime']) {
                        $error= "TOKEN EXPIRED!";
                        $success = false;
                    } else {
                        $error= "";
                        $success = true;
                    }
                } else {
                    $error= "INCORRECT TOKEN VALUE!";
                    $success = false;
                }
            } else {
                $error= "SERVER ERROR!";
                $success = false;
            }
        } else {
            $error= "UNABLE READ INPUTS!";
            $success = false;
        }

        $json_array = array(
            'error' => $error,
            'success' => $success
        );
        return $json_array;
    }

}