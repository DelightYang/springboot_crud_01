package com.springcrud.demo01.services

import com.springcrud.demo01.entities.Item
import com.springcrud.demo01.repositories.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemService {

    @Autowired
    private lateinit var itemRepository: ItemRepository

    fun getItemsList(): Iterable<Item> {
        return itemRepository.findAll()
    }

    fun saveItem(item: Item): Item {
        return itemRepository.save(item)
    }


    fun removeItem(itemId: Int) {
        itemRepository.deleteById(itemId)
    }

}