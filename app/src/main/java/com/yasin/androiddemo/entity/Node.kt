package com.yasin.androiddemo.entity

class Node {
    var value: Int = 0
    var next: Node? = null

    constructor() {}

    constructor(value: Int) {
        this.value = value
    }
}
