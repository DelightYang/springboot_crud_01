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

    @PostMapping("/item")
    fun createItem(@RequestBody item: Item): ResponseEntity<Item> {
        return ResponseEntity(itemService.saveItem(item), HttpStatus.CREATED)
    }

    @GetMapping("/item")
    fun getItems(): Iterable<Item> {
        return itemService.getItemsList()
    }

    @PutMapping("/item")
    fun updateItem(@RequestBody item: Item): ResponseEntity<Item> {
        return ResponseEntity(itemService.saveItem(item), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/item/{id}")
    fun removeItem(@PathVariable("id") id: Int): ResponseEntity<Item> {
        itemService.removeItem(id)
        return ResponseEntity(HttpStatus.ACCEPTED)
    }


}