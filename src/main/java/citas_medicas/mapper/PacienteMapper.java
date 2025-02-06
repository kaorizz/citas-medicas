package citas_medicas.mapper;

import citas_medicas.dominio.Paciente;
import citas_medicas.dto.PacienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    @Mapping(target = "pacientes", source = "pacientes")
    PacienteDTO pacienteToPacienteDTO(Paciente paciente);

    @Mapping(target = "pacientes", source = "pacientes")
    Paciente pacienteDTOToPaciente(PacienteDTO PacienteDTO);
}