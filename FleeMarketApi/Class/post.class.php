<?php

require_once dirname(__FILE__) . '/' . 'db.class.php';
require_once dirname(__FILE__) . '/' . 'json.class.php';
require_once dirname(__FILE__) . '/' . 'define.ini.php';


class Post {

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

    function getRequests($start, $end, $filter=0, $key='') {
        $sqlFilter = '';
        switch ($filter) {
            case 1:
                $sqlFilter .= "ORDER BY dateline DESC";
                break;
            case 2:
                $sqlFilter .= "ORDER BY highPrice DESC";
                break;
            default:
                break;
        }
        if ($key) {
            $sqlFilter .= "WHERE name LIKE '%$key%'";
        }
        $requests = $this->db->fetch_all("SELECT * FROM ".DB_PRE."market_request ".$sqlFilter." LIMIT '$start', '$end'");
        $count = $this->db->result_first("SELECT count(*) FROM ".DB_PRE."market_request ");
        $json_array = array(
            'data' => $requests,
            'total' => (int) $count,
            'success' => true,
            'error' => ""
        );
        $json_string = $this->json->jsonFormat($json_array);
        $json_string = preg_replace("#\\\u([0-9a-f]{4})#ie", "iconv('UCS-2BE', 'UTF-8', pack('H4', '\\1'))", $json_string);
        echo stripslashes($json_string);

    }

    function getOffers($start, $end, $filter=0, $key='') {
        $sqlFilter = '';
        switch ($filter) {
            case 1:
                $sqlFilter .= "ORDER BY dateline DESC";
                break;
            case 2:
                $sqlFilter .= "ORDER BY price DESC";
                break;
            default:
                break;
        }
        if ($key) {
            $sqlFilter .= "WHERE name LIKE '%$key%'";
        }
        $offers = $this->db->fetch_all("SELECT * FROM ".DB_PRE."market_offer ".$sqlFilter." LIMIT '$start', '$end'");
        $count = $this->db->result_first("SELECT count(*) FROM ".DB_PRE."market_offer ");
        $json_array = array(
            'data' => $offers,
            'total' => (int) $count,
            'success' => true,
            'error' => ""
        );
        $json_string = $this->json->jsonFormat($json_array);
        $json_string = preg_replace("#\\\u([0-9a-f]{4})#ie", "iconv('UCS-2BE', 'UTF-8', pack('H4', '\\1'))", $json_string);
        echo stripslashes($json_string);

    }

    function createRequest($name, $category, $uid, $username, $lowPrice, $highPrice, $payment, $shipment, $extra){
        $this->db->query("INSERT INTO ".DB_PRE."market_request (`name`, category, requesterId, requester, lowPrice, highPrice, payment, shipment, extra, dateline) VALUES('$name', '$category', '$uid', '$username', '$lowPrice', '$highPrice', '$payment', '$shipment', '$extra', '$this->time')");
        $json_array = array(
            'success' => true,
            'error' => ""
        );
        $json_string = $this->json->jsonFormat($json_array);
        $json_string = preg_replace("#\\\u([0-9a-f]{4})#ie", "iconv('UCS-2BE', 'UTF-8', pack('H4', '\\1'))", $json_string);
        echo stripslashes($json_string);
    }

    function createOffer($name, $category, $uid, $username, $price, $payment, $shipment, $extra){
        $this->db->query("INSERT INTO ".DB_PRE."market_offer (`name`, category, sellerId, seller, price, payment, shipment, extra, dateline) VALUES('$name', '$category', '$uid', '$username', '$price', '$payment', '$shipment', '$extra', '$this->time')");
        $json_array = array(
            'success' => true,
            'error' => ""
        );
        $json_string = $this->json->jsonFormat($json_array);
        $json_string = preg_replace("#\\\u([0-9a-f]{4})#ie", "iconv('UCS-2BE', 'UTF-8', pack('H4', '\\1'))", $json_string);
        echo stripslashes($json_string);
    }


}