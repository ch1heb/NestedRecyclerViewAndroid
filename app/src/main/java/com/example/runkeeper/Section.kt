package com.example.runkeeper

data class Section(
    var sectionName: String,
    var sectionCount: String?,
    var sectionItems: ArrayList<AchItem>
)