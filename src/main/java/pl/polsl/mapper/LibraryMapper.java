package pl.polsl.mapper;

import pl.polsl.dto.LibrarianDTO;
import pl.polsl.dto.ReaderDTO;
import pl.polsl.dto.RoleDTO;
import pl.polsl.dto.UserDTO;
import pl.polsl.model.LibrarianEntity;
import pl.polsl.model.ReaderEntity;
import pl.polsl.model.RolesEntity;
import pl.polsl.model.UsersEntity;

import java.util.List;

/**
 * Created by Katarzyna on 06.12.2016.
 */
public interface LibraryMapper {
    RolesEntity toRolesEntity(RoleDTO roleDTO);

    List<RolesEntity> toRolesEntityList(List<RoleDTO> roleDTOList);

    RoleDTO toRoleDTO(RolesEntity rolesEntity);

    List<RoleDTO> toRoleDTOList(List<RolesEntity> rolesEntityList);

    UsersEntity toUsersEntity(UserDTO userDTO);

    List<UsersEntity> toUsersEntityList(List<UserDTO> userDTOList);

    UserDTO toUserDTO(UsersEntity usersEntity);

    List<UserDTO> toUserDTOList(List<UsersEntity> usersEntityList);

    LibrarianEntity toLibrarianEntity(LibrarianDTO librarianDTO);

    List<LibrarianEntity> toLibrarianEntityList(List<LibrarianDTO> librarianDTOList);

    LibrarianDTO toLibrarianDTO(LibrarianEntity librarianEntity);

    List<LibrarianDTO> toLibrarianDTOList(List<LibrarianEntity> librarianEntityList);

    ReaderEntity toReaderEntity(ReaderDTO readerDTO);

    List<ReaderEntity> toReaderEntityList(List<ReaderDTO> readerDTOList);

    ReaderDTO toReaderDTO(ReaderEntity readerEntity);

    List<ReaderDTO> toReaderDTOList(List<ReaderEntity> readerEntityList);
}
