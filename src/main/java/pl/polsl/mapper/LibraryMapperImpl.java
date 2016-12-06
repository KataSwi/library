package pl.polsl.mapper;

import org.springframework.stereotype.Component;
import pl.polsl.dto.LibrarianDTO;
import pl.polsl.dto.ReaderDTO;
import pl.polsl.dto.RoleDTO;
import pl.polsl.dto.UserDTO;
import pl.polsl.model.LibrarianEntity;
import pl.polsl.model.ReaderEntity;
import pl.polsl.model.RolesEntity;
import pl.polsl.model.UsersEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katarzyna on 06.12.2016.
 */
@Component
public class LibraryMapperImpl implements LibraryMapper {
    @Override
    public RolesEntity toRolesEntity(RoleDTO roleDTO) {
        if(roleDTO==null){
            return null;
        }
        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setType(roleDTO.getType());
        rolesEntity.setRoleid(roleDTO.getRoleid());
        return rolesEntity;
    }

    @Override
    public List<RolesEntity> toRolesEntityList(List<RoleDTO> roleDTOList) {
        if (roleDTOList == null) {
            return null;
        }
        List<RolesEntity> result = new ArrayList<>();
        roleDTOList.forEach(roleDTO -> result.add(toRolesEntity(roleDTO)));
        return result;
    }

    @Override
    public RoleDTO toRoleDTO(RolesEntity rolesEntity) {
        if (rolesEntity == null) {
            return null;
        }
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleid(rolesEntity.getRoleid());
        roleDTO.setType(rolesEntity.getType());
        return roleDTO;
    }

    @Override
    public List<RoleDTO> toRoleDTOList(List<RolesEntity> rolesEntityList) {
        if (rolesEntityList == null) {
            return null;
        }
        List<RoleDTO> result = new ArrayList<>();
        rolesEntityList.forEach(rolesEntity -> result.add(toRoleDTO(rolesEntity)));
        return result;
    }

    @Override
    public UsersEntity toUsersEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUserName(userDTO.getUserName());
        usersEntity.setName(userDTO.getName());
        usersEntity.setSurname(userDTO.getSurname());
        usersEntity.setPassword(userDTO.getPassword());
        usersEntity.setRoleid(userDTO.getRoleid());
        usersEntity.setEmail(userDTO.getEmail());
        usersEntity.setUsersByRole(toRolesEntity(userDTO.getRoleDTO()));
        return usersEntity;
    }

    @Override
    public List<UsersEntity> toUsersEntityList(List<UserDTO> userDTOList) {
        if (userDTOList == null) {
            return null;
        }
        List<UsersEntity> result = new ArrayList<>();
        userDTOList.forEach(userDTO -> result.add(toUsersEntity(userDTO)));
        return result;
    }

    @Override
    public UserDTO toUserDTO(UsersEntity usersEntity) {
        if (usersEntity == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(usersEntity.getUserName());
        userDTO.setName(usersEntity.getName());
        userDTO.setSurname(usersEntity.getSurname());
        userDTO.setRoleid(usersEntity.getRoleid());
        userDTO.setPassword(usersEntity.getPassword());
        userDTO.setEmail(usersEntity.getEmail());
        userDTO.setRoleDTO(toRoleDTO(usersEntity.getUsersByRole()));
        return userDTO;
    }

    @Override
    public List<UserDTO> toUserDTOList(List<UsersEntity> usersEntityList) {
        if (usersEntityList == null) {
            return null;
        }
        List<UserDTO> result = new ArrayList<>();
        usersEntityList.forEach(usersEntity -> result.add(toUserDTO(usersEntity)));
        return result;
    }

    @Override
    public LibrarianEntity toLibrarianEntity(LibrarianDTO librarianDTO) {
        if(librarianDTO == null){
            return null;
        }
        LibrarianEntity librarianEntity = new LibrarianEntity();
        librarianEntity.setLibrarianid(librarianDTO.getLibrarianid());
        librarianEntity.setUserName(librarianDTO.getUserName());
        librarianEntity.setLibrarianUser(toUsersEntity(librarianDTO.getUserDTO()));
        return librarianEntity;
    }

    @Override
    public List<LibrarianEntity> toLibrarianEntityList(List<LibrarianDTO> librarianDTOList) {
        if (librarianDTOList == null) {
            return null;
        }
        List<LibrarianEntity> result = new ArrayList<>();
        librarianDTOList.forEach(librarianDTO -> result.add(toLibrarianEntity(librarianDTO)));
        return result;
    }

    @Override
    public LibrarianDTO toLibrarianDTO(LibrarianEntity librarianEntity) {
        if (librarianEntity == null) {
            return null;
        }
        LibrarianDTO librarianDTO = new LibrarianDTO();
        librarianDTO.setLibrarianid(librarianEntity.getLibrarianid());
        librarianDTO.setUserName(librarianEntity.getUserName());
        librarianDTO.setUserDTO(toUserDTO(librarianEntity.getLibrarianUser()));
        return librarianDTO;
    }

    @Override
    public List<LibrarianDTO> toLibrarianDTOList(List<LibrarianEntity> librarianEntityList) {
        if (librarianEntityList == null) {
            return null;
        }
        List<LibrarianDTO> result = new ArrayList<>();
        librarianEntityList.forEach(librarianEntity -> result.add(toLibrarianDTO(librarianEntity)));
        return result;
    }

    @Override
    public ReaderEntity toReaderEntity(ReaderDTO readerDTO) {
        if(readerDTO == null){
            return null;
        }
        ReaderEntity readerEntity = new ReaderEntity();
        readerEntity.setCardNumber(readerDTO.getCardNumber());
        readerEntity.setUserName(readerDTO.getUserName());
        readerEntity.setReaderUser(toUsersEntity(readerDTO.getUserDTO()));
        return readerEntity;
    }

    @Override
    public List<ReaderEntity> toReaderEntityList(List<ReaderDTO> readerDTOList) {
        if (readerDTOList == null) {
            return null;
        }
        List<ReaderEntity> result = new ArrayList<>();
        readerDTOList.forEach(readerDTO -> result.add(toReaderEntity(readerDTO)));
        return result;
    }

    @Override
    public ReaderDTO toReaderDTO(ReaderEntity readerEntity) {
        if (readerEntity == null) {
            return null;
        }
        ReaderDTO readerDTO = new ReaderDTO();
        readerDTO.setCardNumber(readerEntity.getCardNumber());
        readerDTO.setUserName(readerEntity.getUserName());
        readerDTO.setUserDTO(toUserDTO(readerEntity.getReaderUser()));
        return readerDTO;
    }

    @Override
    public List<ReaderDTO> toReaderDTOList(List<ReaderEntity> readerEntityList) {
        if (readerEntityList == null) {
            return null;
        }
        List<ReaderDTO> result = new ArrayList<>();
        readerEntityList.forEach(readerEntity -> result.add(toReaderDTO(readerEntity)));
        return result;
    }
}
