package com.hbsites.rpgtracker.coc.service;

import com.hbsites.rpgtracker.coc.dto.CoCSessionDTO;
import com.hbsites.rpgtracker.coc.entity.CoCSessionEntity;
import com.hbsites.rpgtracker.coc.repository.CoCSessionRepository;
import com.hbsites.rpgtracker.core.interfaces.CRUDService;
import com.hbsites.rpgtracker.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CoCSessionService implements CRUDService<UUID, CoCSessionDTO, CoCSessionDTO, CoCSessionDTO> {

    @Autowired
    @Lazy
    private CoCSessionRepository repository;

    @Autowired
    @Lazy
    private UserService userService;

    @Override
    public List<CoCSessionDTO> getAll() {
        return repository.findAll().stream().map(CoCSessionEntity::toListDTO).collect(Collectors.toList());
    }

    @Override
    public CoCSessionDTO create(CoCSessionDTO coCSessionDTO) {
        CoCSessionEntity e = coCSessionDTO.toEntity();
        e.setDmId(userService.getUserUUID());
        e = repository.save(e);
        return e.toDetailDTO();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public CoCSessionDTO getById(UUID id) {
        return findEntityOrElseThrow(id).toDetailDTO();
    }

    @Override
    public CoCSessionDTO update(UUID id, CoCSessionDTO payload) {
        CoCSessionEntity e = findEntityOrElseThrow(id);
        e.setSessionName(payload.getSessionName());
        e.setPulpCthulhu(payload.getPulpCthulhu());
        e = repository.save(e);
        return e.toDetailDTO();
    }

    private CoCSessionEntity findEntityOrElseThrow(UUID uuid) {
        return repository.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
