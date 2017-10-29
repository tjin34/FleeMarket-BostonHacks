<?php

/**
 * @SWG\GET(
 *     path= "/User/getUserInfo.php",
 *     tags={"User"},
 *     summary="Get Personal Profile",
 *     description="Get Personal Profile",
 *     @SWG\Parameter(
 *         name="uid",
 *         in="query",
 *         description="User ID",
 *         required=true,
 *         type="integer",
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

$uid = $_GET['uid'];
$token = $_GET['token'];

if (!empty($uid) && !empty($token)) {

    require_once dirname(__FILE__).'/'.'../class/user.class.php';
    $login = new User();
    $login->getUserInfo($uid,$token);

}