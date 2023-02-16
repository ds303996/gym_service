package com.jetrouter.gymservice.service.impl;

import com.jetrouter.gymservice.repository.MembersRepository;
import com.jetrouter.gymservice.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final MembersRepository membersRepository;

    @Override
    @Transactional(readOnly = true)
    public byte[] getImage(String principalName) {
        var member = membersRepository.findByName(principalName).orElseThrow();
        return member.getImage();
    }

    @Override
    @Transactional
    public void updateImage(byte[] image, String principalName) {
        var member = membersRepository.findByName(principalName).orElseThrow();
        member.setImage(image);
        membersRepository.save(member);
    }
}
