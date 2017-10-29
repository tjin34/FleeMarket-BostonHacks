<?php

/**
 * @SWG\Definition(type="object", @SWG\Xml(name="LoginReq"))
 */
class LoginReq {

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $username;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $password;
}

/**
 * @SWG\Definition(type="object", @SWG\Xml(name="RegisterReq"))
 */
class RegisterReq {

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $username;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $password;
}

/**
 * @SWG\Definition(type="object", @SWG\Xml(name="CreatePostReq"))
 */
class CreatePostReq {

    /**
     * @SWG\Property(example=0)
     * @var integer
     */
    public $uid;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $username;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $name;

    /**
     * @SWG\Property(example=0)
     * @var integer
     */
    public $type;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $category;

    /**
     * @SWG\Property(example=0)
     * @var integer
     */
    public $lowPrice;

    /**
     * @SWG\Property(example=0)
     * @var integer
     */
    public $highPrice;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $payment;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $shipment;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $extra;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $token;


}


