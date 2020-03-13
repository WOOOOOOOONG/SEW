package com.kh.spring.classs.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.classs.model.vo.Classs;
import com.kh.spring.common.model.vo.Category;
import com.kh.spring.common.model.vo.Storage;

@Repository("cDao")
public class ClassDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 클래스 넣기
	public int insertClasss(Classs c) {
		return sqlSession.insert("ClasssMapper.insertClass",c);
	}

	// 넣은 클래스 아이디가져오기
	public String selectCNoOne(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ClasssMapper.selectcNoOne",id);
	}

	// 클래스에 파일넣기
	public int insertClassFile(Storage s) {
		// TODO Auto-generated method stub
		return sqlSession.insert("StorageMapper.insertClassFile",s);
	}

	// 클래스 리스트 전체 가져오기
	public ArrayList<Classs> selectClassList() {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("ClasssMapper.selectClassList");
	}

	// 카테고리 리스트
	public ArrayList<Category> selectCateList() {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("ClasssMapper.selectCateList");
	}

	// 클래스에 맞는 파일 가져오기
	public ArrayList<Storage> selectFileList(String cNo) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("StorageMapper.selectFileList",cNo);
	}

	// 카운트 증가되는 클래스 가져오기
	public Classs selectClassOneCount(String cNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ClasssMapper.selectClassOne",cNo);
	}

	// 조회수 증가
	public int upCount(String cNo) {
		return sqlSession.update("ClasssMapper.upCount",cNo);
	}

	// 카테고리로 클래스 찾기
	public ArrayList<Classs> searchClassList(String cateList) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("ClasssMapper.searchClassList",cateList);
		
	}

	public ArrayList<Classs> getClassnVoca(String mId) {
		
		return (ArrayList)sqlSession.selectList("ClasssMapper.getClassnVoca",mId);
	}

}
