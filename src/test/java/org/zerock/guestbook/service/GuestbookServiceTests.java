package org.zerock.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

@SpringBootTest
public class GuestbookServiceTests {

    @Autowired
    private GuestbookService guestbookService;

    @Test
    public void registOneEntity() {

        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Test Title....")
                .content("Test Content...")
                .writer("user0")
                .build();

        System.out.println(guestbookService.register(guestbookDTO));

    }

    @Test
    public void isChangeEntityToDto() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<GuestbookDTO, Guestbook> pageResultDTO = guestbookService.getList(pageRequestDTO);

        System.out.println("PREV: " + pageResultDTO.isPrev());
        System.out.println("NEXT: " + pageResultDTO.isNext());
        System.out.println("TOTAL: " + pageResultDTO.getTotalPage());
        System.out.println("--------------------------------------------------");
        for (GuestbookDTO dto : pageResultDTO.getDtoList()) {
            System.out.println(dto);
        }
        System.out.println("--------------------------------------------------");
        pageResultDTO.getPageList().forEach(i -> System.out.println(i));
    }

    @Test
    public void testSearch() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("tc")
                .keyword("한글")
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> pageResultDTO = guestbookService.getList(pageRequestDTO);

        System.out.println("PREV: " + pageResultDTO.isPrev());
        System.out.println("NEXT: " + pageResultDTO.isNext());
        System.out.println("TOTAL: " + pageResultDTO.getTotalPage());
        System.out.println("--------------------------------------------------");
        for (GuestbookDTO dto : pageResultDTO.getDtoList()) {
            System.out.println(dto);
        }
        System.out.println("--------------------------------------------------");
        pageResultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
