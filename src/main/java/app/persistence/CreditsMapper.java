package app.persistence;

import app.DTOs.CastMemberDTO;
import app.DTOs.CreditsDTO;
import app.DTOs.CrewMemberDTO;
import app.entities.CastMember;
import app.entities.Credits;
import app.entities.CrewMember;

import java.util.ArrayList;
import java.util.List;


public class CreditsMapper {

    public Credits toEntity(CreditsDTO dto) {
        Credits credits = new Credits();
        credits.setId(dto.getId());
        CastMemberMapper castMemberMapper = new CastMemberMapper();
        CrewMemberMapper crewMemberMapper = new CrewMemberMapper();
        List<CastMember> castMemberList = new ArrayList<>();
        List<CrewMember> crewMemberList = new ArrayList<>();

        for (CastMemberDTO castMemberDTO : dto.getCast()){
            CastMember castMemberEntity = castMemberMapper.toEntity(castMemberDTO);
            castMemberEntity.setCredits(credits);
            castMemberList.add(castMemberEntity);
        }
        credits.setCast(castMemberList);
        for (CrewMemberDTO crewMemberDTO : dto.getCrew()){
            CrewMember crewMemberEntity = crewMemberMapper.toEntity(crewMemberDTO);
            crewMemberEntity.setCredits(credits);
            crewMemberList.add(crewMemberEntity);
        }
        credits.setCrew(crewMemberList);
        return credits;
    }

    public CreditsDTO toDTO(Credits entity) {
        return null;
    }
}
