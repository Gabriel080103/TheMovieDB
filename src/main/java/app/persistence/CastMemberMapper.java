package app.persistence;

import app.DTOs.CastMemberDTO;
import app.entities.CastMember;

public class CastMemberMapper {

    public CastMember toEntity(CastMemberDTO dto) {
        CastMember castMember = new CastMember();
        castMember.setCreditId(dto.getCreditId());
        castMember.setPersonId(dto.getPersonId());
        castMember.setAdult(dto.isAdult());
        castMember.setGender(dto.getGender());
        castMember.setKnownForDepartment(dto.getKnownForDepartment());
        castMember.setName(dto.getName());
        castMember.setOriginalName(dto.getOriginalName());
        castMember.setPopularity(dto.getPopularity());
        castMember.setProfilePath(dto.getProfilePath());
        castMember.setCastId(dto.getCastId());
        castMember.setCharacter(dto.getCharacter());
        castMember.setCastOrder(dto.getOrder());
        return castMember;
    }
}

