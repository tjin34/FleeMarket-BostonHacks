<?php


/**
 * @SWG\GET(
 *     path= "/Market/getPosts.php",
 *     tags={"Market"},
 *     summary="get posts",
 *     description="0 -> requests, 1 -> offers",
 *     @SWG\Parameter(
 *         name="uid",
 *         in="query",
 *         description="User ID",
 *         required=true,
 *         type="integer",
 *     ),
 *     @SWG\Parameter(
 *         name="type",
 *         in="query",
 *         description="post type",
 *         required=true,
 *         type="integer",
 *     ),
 *     @SWG\Parameter(
 *         name="pageIndex",
 *         in="query",
 *         description="page number",
 *         required=false,
 *         type="integer",
 *     ),
 *     @SWG\Parameter(
 *         name="pageSize",
 *         in="query",
 *         description="how many items a page has",
 *         required=false,
 *         type="integer",
 *     ),
 *     @SWG\Parameter(
 *         name="filter",
 *         in="query",
 *         description="filter rules",
 *         required=false,
 *         type="integer",
 *     ),
 *     @SWG\Parameter(
 *         name="key",
 *         in="query",
 *         description="search key",
 *         required=false,
 *         type="string",
 *     ),
 *     @SWG\Parameter(
 *         name="token",
 *         in="query",
 *         description="token value",
 *         required=true,
 *         type="string",
 *     ),
 *    @SWG\Response(
 *         response=200,
 *         description="Response Code",
 *         @SWG\Schema(ref="#/definitions/DataResponse"),
 *     ),
 * )
 */

require_once dirname(__FILE__).'/'.'../class/user.class.php';
require_once dirname(__FILE__).'/'.'../class/post.class.php';
require_once dirname(__FILE__).'/'.'../class/json.class.php';
$login = new User();
$post = new Post();
$json = new JSON();


$uid = $_GET['uid'];
$type = $_GET['type'];
$filter = $_GET['filter'];
$key = $_GET['key'];
$pageIndex = $_GET['pageIndex'];
$pageSize = $_GET['pageSize'];
$token = $_GET['token'];

if (empty($pageIndex)) {
    $start = 0;
    if (empty($pageSize)) {
        $num = 10;
    } else {
        $num = $pageSize;
    }
} else {
    if (empty($pageSize)) {
        $start = 10 * ($pageIndex-1);
        $num = 10;
    } else {
        $start = $pageSize * ($pageIndex-1);
        $num = $pageSize;
    }
}
$end = $start + $num;

if (!empty($uid) && !empty($token)) {

    $verify = $login->verify($uid, $token);
    if ($verify['success'] == true) {
        switch (type) {
            case 0:
                $post->getRequests($start, $end, $filter, $key);
                break;
            case 1:
                $post->getOffers($start, $end, $filter, $key);
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
}