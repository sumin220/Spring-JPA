package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item.Book;
import jpabook.jpashop.domain.Item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 물품저장() throws Exception {

        // given
        Book book = new Book();
        book.setName("JPA");
        book.setPrice(20000);
        book.setStockQuantity(10);
        book.setAuthor("Author Name");
        book.setIsbn("123-456");

        // when
        itemService.saveItem(book);
        Long savedItemId = book.getId();
        Item foundItem = itemRepository.findOne(savedItemId);

        // then
        assertThat(foundItem).isNotNull();
        assertThat(foundItem.getName()).isEqualTo("JPA");
    }
}