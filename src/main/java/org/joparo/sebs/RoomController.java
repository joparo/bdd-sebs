package org.joparo.sebs;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private Repository repository;

    public RoomController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Room> getRooms() {
        return this.repository.findAll();
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return this.repository.save(room);
    }

    @GetMapping("/{id}")
    public Room findRoom(@PathVariable long id) {
        return this.repository.findRoom(id);
    }

}
