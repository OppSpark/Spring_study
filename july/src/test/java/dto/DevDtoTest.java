package dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class DevDtoTest {
    @Test
    void test(){
        DevDto devDto = new DevDto();

        devDto.setName("snow");
        devDto.setAge(21);
        devDto.setStartAT(LocalDateTime.now());

        System.out.println(devDto);

    }
}