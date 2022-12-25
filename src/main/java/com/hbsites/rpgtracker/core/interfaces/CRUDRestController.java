package com.hbsites.rpgtracker.core.interfaces;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CRUDRestController<LISTDTO, DETAILDTO, IDCLASS, CREATEDTO> {

    @GetMapping
    List<LISTDTO> getAll();

    @PostMapping
    DETAILDTO create(@RequestBody CREATEDTO dto);

    @GetMapping("/{uuid}")
    DETAILDTO getOne(@PathVariable IDCLASS uuid);

    @PutMapping("/{uuid}")
    DETAILDTO update(@PathVariable IDCLASS uuid, @RequestBody CREATEDTO dto);

    @DeleteMapping("/{uuid}")
    void delete(@PathVariable IDCLASS uuid);

}
