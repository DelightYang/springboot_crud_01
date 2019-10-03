package com.springcrud.demo01.entities

import javax.persistence.*

// 创建实体类 Entity类

@Entity
@Table(name = "items")
data class Item (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    var name: String


)