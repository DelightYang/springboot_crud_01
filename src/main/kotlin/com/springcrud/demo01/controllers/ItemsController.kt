package com.springcrud.demo01.controllers

import com.springcrud.demo01.entities.Item
import com.springcrud.demo01.services.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class ItemsController {

    @Autowired
    lateinit var itemService: ItemService



    /**
     * POST create item 增
     *
     * 注意如果要接收多个items / 元素 / 数据个数大于1
     * 要使用array数组形式，而不是@RequestBody是单个元素
     *
     * 在这里插入createOn时间戳
     */
    @PostMapping("/items")
    fun createItem(@RequestBody list: List<Item>):ResponseEntity<Any> {
        itemService.saveItem(list)
        return ResponseEntity(HttpStatus.CREATED)
    }

    /**
     * Delete 删 删除item
     */
    @DeleteMapping("/items/{id}")
    fun removeItem(@PathVariable("id") id: Int): ResponseEntity<Any> {
        itemService.removeItem(id)
        return ResponseEntity(HttpStatus.ACCEPTED)
    }

    /**
     * Put 改 更新update信息，修改信息
     *
     * 并插入updateOn的时间戳；因为都用的是save方法，要和post区分开
     */
    @PutMapping("/items")
    fun updateItem(@RequestBody list: List<Item>):ResponseEntity<Any> {
        itemService.updateItem(list)
        return ResponseEntity(HttpStatus.OK)
    }

    /**
     * GET 查 查看item
     *
     * 状态值是200ok 这里看是返回状态还是数据
     */
    @GetMapping("/items")
    fun getItems(): Iterable<Item> {
        return itemService.getItemsList()
    }


}