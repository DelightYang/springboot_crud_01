package com.springcrud.demo01.repositories

import com.springcrud.demo01.entities.Item
import org.springframework.data.repository.CrudRepository

// 注意这里是Int 不是Integer 或者可换成Long 和数据库表对应
interface ItemRepository : CrudRepository<Item, Int>