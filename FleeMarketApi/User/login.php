<?php

/**
 * @SWG\Post(
 *     path="/User/login.php",
 *     tags={"User"},
 *     summary="User login",
 *     description="username + password",
 *     consumes={"application/json"},
 *     produces={"application/json"},
 *     @SWG\Parameter(
 *         name="LoginReq",
 *         in="body",
 *         description="username + password JSON",
 *         required=true,
 *         type="application/json",
 *         @SWG\Schema(ref="#/definitions/LoginReq"),
 *     ),
 *    @SWG\Response(
 *         response=200,
 *         description="Response Code",
 *         @SWG\Schema(ref="#/definitions/DataResponse"),
 *     ),
 * )
 */

$postJson = file_get_contents("php://input");

$postArray = json_decode($postJson, true);

$username = $postArray['username'];
$password = $postArray['password'];

require_once dirname(__FILE__) . '/' . '../Class/user.class.php';
$User = new User();
$User->login($username,$password);