package pl.polsl.mapper;

import pl.polsl.dto.*;
import pl.polsl.model.*;

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

    AuthorEntity toAuthorEntity(AuthorDTO authorDTO);

    List<AuthorEntity> toAuthorEntityList(List<AuthorDTO> authorDTOList);

    AuthorDTO toAuthorDTO(AuthorEntity authorEntity);

    List<AuthorDTO> toAuthorDTOList(List<AuthorEntity> authorEntityList);

    BookEntity toBookEntity(BookDTO bookDTO);

    List<BookEntity> toBookEntityList(List<BookDTO> bookDTOList);

    BookDTO toBookDTO (BookEntity bookEntity);

    List<BookDTO> toBookDTOList(List<BookEntity> bookEntityList);

    BookcopyEntity toBookCopyEntity(BookCopyDTO bookCopyDTO);

    List<BookcopyEntity> toBookCopyEntityList(List<BookCopyDTO> bookCopyDTOList);

    BookCopyDTO toBookCopyDTO(BookcopyEntity bookcopyEntity);

    List<BookCopyDTO> toBookCopyDTOList(List<BookcopyEntity> bookcopyEntityList);

    GenreEntity toGenreEntity(GenreDTO genreDTO);

    List<GenreEntity> toGenreEntityList(List<GenreDTO> genreDTOList);

    GenreDTO toGenreDTO(GenreEntity genreEntity);

    List<GenreDTO> toGenreDTOList(List<GenreEntity> genreEntityList);

    BookstateEntity toBookStateEntity(BookStateDTO bookStateDTO);

    List<BookstateEntity> toBookStateEntityList(List<BookStateDTO> bookStateDTOList);

    BookStateDTO toBookStateDTO(BookstateEntity bookstateEntity);

    BorrowedbooksEntity toBorrowedBooksEntity(BorrowedBooksDTO borrowedBooksDTO);

    List<BorrowedbooksEntity> toBorrowedBooksEntityList(List<BorrowedBooksDTO> borrowedBooksDTOList);

    BorrowedBooksDTO toBorrowedBooksDTO(BorrowedbooksEntity borrowedbooksEntity);

    List<BorrowedBooksDTO> toBorrowedBooksDTOList(List<BorrowedbooksEntity> borrowedbooksEntityList);

    ReservationEntity toReservationEntity(ReservationDTO reservationDTO);

    List<ReservationEntity> toReservationEntityList(List<ReservationDTO> reservationEntityList);

    ReservationDTO toReservationDTO(ReservationEntity reservationEntity);

    List<ReservationDTO> toReservationDTOList(List<ReservationEntity> reservationEntityList);
}
