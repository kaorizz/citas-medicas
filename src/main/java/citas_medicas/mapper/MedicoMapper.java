package citas_medicas.mapper;

import citas_medicas.dominio.Medico;
import citas_medicas.dto.MedicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    @Mapping(target = "citas", source = "citas")
    MedicoDTO medicoToMedicoDTO(Medico medico);

    @Mapping(target = "citas", source = "citas")
    Medico medicoDTOToMedico(MedicoDTO medicoDTO);
}