<?php

/**
 * @SWG\Post(
 *     path="/Market/createPost.php",
 *     tags={"Market"},
 *     summary="create posts",
 *     description="0 -> request, 1 -> offer",
 *     consumes={"application/json"},
 *     produces={"application/json"},
 *     @SWG\Parameter(
 *         name="CreatePostReq",
 *         in="body",
 *         description="username + password JSON",
 *         required=true,
 *         type="application/json",
 *         @SWG\Schema(ref="#/definitions/CreatePostReq"),
 *     ),
 *    @SWG\Response(
 *         response=200,
 *         description="Response Code",
 *         @SWG\Schema(ref="#/definitions/SimpleResponse"),
 *     ),
 * )
 */

require_once dirname(__FILE__) . '/' . '../Class/user.class.php';
require_once dirname(__FILE__) . '/' . '../Class/post.class.php';
require_once dirname(__FILE__) . '/' . '../Class/json.class.php';
$User = new User();
$post = new Post();
$json = new JSON();

$postJson = file_get_contents("php://input");

$postArray = json_decode($postJson, true);

$uid = $postArray['uid'];
$username = $postArray['username'];
$type = $postArray['type'];
$name = $postArray['name'];
$category = $postArray['category'];
$lowPrice = $postArray['lowPrice'];
$highPrice = $postArray['highPrice'];
$payment = $postArray['payment'];
$shipment = $postArray['shipment'];
$extra = $postArray['extra'];
$token = $postArray['token'];

$verify = $User->verify($uid,$token);
if ($verify['success'] == true) {
    switch ($type) {
        case 0:
            $post->createRequest($name, $category, $uid, $username, $lowPrice, $highPrice, $payment, $shipment, $extra);
            break;
        case 1:
            $post->createOffer($name, $category, $uid, $username, $highPrice, $payment, $shipment, $extra);
            break;
    }
} else {
    $json_array = array(
        'success' => false,
        'error' => $verify['error']
    );
    $json_string = $json->jsonFormat($json_array);
    $json_string = preg_replace("#\\\u([0-9a-f]{4})#ie", "iconv('UCS-2BE', 'UTF-8', pack('H4', '\\1'))", $json_string);
    echo stripslashes($json_string);
}