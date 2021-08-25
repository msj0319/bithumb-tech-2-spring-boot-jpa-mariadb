package net.msj0319.api.item.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import net.msj0319.api.item.domain.Item;
import net.msj0319.api.item.service.ItemService;
import net.msj0319.api.order.domain.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Api
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false")
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Item>> findById(@PathVariable long id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody Item item) {
        itemService.save(item);
    }

    @PutMapping
    public void update(@RequestBody Item item){
        itemService.save(item);
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsById(long id) {
        return ResponseEntity.ok(itemService.existsById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity(itemService.count(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        itemService.deleteById(id);
    }

    //deleteAll 메서드에 대한 @DeleteMapping 과 페이지 오류, 서버 오류에 대한 ApiResponse 설정 예시
    //아래 ApiResponse는 여러 메소드에도 작성할 수 있다.
    @DeleteMapping
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Something went wrong"),
                            @ApiResponse(code = 403, message = "Access Denied"),
                            @ApiResponse(code = 422, message = "Item is alredy in use") })

    public void deleteAll(){
        itemService.deleteAll();
    }
}