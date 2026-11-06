package com.example.memoapi.mapper;

import com.example.memoapi.dto.Note;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT id,title,content,create_at FROM notes ORDER BY create_at DESC")
    List<Note> findAll();

    @Insert("insert into notes (title,content) values (#{title},#{content})")
    @Options(useGeneratedKeys = true,keyProperty = "id,createdAt",keyColumn = "id,created_at")
    int insert(Note note);

    @Select("SELECT id,title,content,created_at FROM notes WHERE id = #{id}")
    Note findById(long id);
}
