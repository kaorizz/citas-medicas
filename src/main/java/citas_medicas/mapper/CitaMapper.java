package citas_medicas.mapper;

import citas_medicas.dominio.Cita;
import citas_medicas.dto.CitaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CitaMapper {
    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);

    @Mapping(target = "diagnostico", ignore = true)  // 🚨 Evita la recursión
    CitaDTO citaToCitaDTO(Cita cita);

    Cita citaDTOToCita(CitaDTO citaDTO);
}