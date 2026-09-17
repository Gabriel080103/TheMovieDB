package app.persistence;

import app.DTOs.CrewMemberDTO;
import app.entities.CrewMember;

public class CrewMemberMapper {

    public CrewMember toEntity(CrewMemberDTO dto) {
        CrewMember crewMember = new CrewMember();
        crewMember.setPersonId(dto.getPersonId());
        crewMember.setName(dto.getName());
        crewMember.setGender(dto.getGender());
        crewMember.setKnownForDepartment(dto.getKnownForDepartment());
        crewMember.setOriginalName(dto.getOriginalName());
        crewMember.setPopularity(dto.getPopularity());
        crewMember.setProfilePath(dto.getProfilePath());
        crewMember.setCreditId(dto.getCreditId());
        crewMember.setDepartment(dto.getDepartment());
        crewMember.setJob(dto.getJob());
        return crewMember;
    }
}
