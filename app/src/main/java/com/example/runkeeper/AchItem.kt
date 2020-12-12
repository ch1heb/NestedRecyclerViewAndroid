package com.example.runkeeper

class AchItem {

    var icons:Int ? = 0
    var Achtype:String ? = null
    var record:String?=null

    constructor(icons: Int?, Achtype: String?, record: String?) {
        this.icons = icons
        this.Achtype = Achtype
        this.record=record
    }
}