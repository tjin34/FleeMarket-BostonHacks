<?php

/**
 * @SWG\Definition(type="object", @SWG\Xml(name="SimpleResponse"))
 */
class SimpleResponse {

    /**
     * @SWG\Property(example=true)
     * @var boolean
     */
    public $success;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $error;
}

/**
 * @SWG\Definition(type="object", @SWG\Xml(name="DataResponse"))
 */
class DataResponse {

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $data;

    /**
     * @SWG\Property(example=true)
     * @var boolean
     */
    public $success;

    /**
     * @SWG\Property(example="")
     * @var string
     */
    public $error;
}