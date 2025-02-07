package citas_medicas.mapper;

import citas_medicas.dominio.Diagnostico;
import citas_medicas.dto.DiagnosticoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DiagnosticoMapper {
    DiagnosticoMapper INSTANCE = Mappers.getMapper(DiagnosticoMapper.class);

    @Mapping(target = "cita", ignore = true)  // 🚨 Evita la recursión
    DiagnosticoDTO diagnosticoToDiagnosticoDTO(Diagnostico diagnostico);

    Diagnostico diagnosticoDTOToDiagnostico(DiagnosticoDTO diagnosticoDTO);
}