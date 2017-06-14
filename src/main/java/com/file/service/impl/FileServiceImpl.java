package com.file.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.file.File;
import com.file.FileRepository;
import com.file.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	public FileRepository fileRepository;

	@Override
	public File saveFile(File file) {
		return fileRepository.save(file);
	}

	@Override
	public void removeFile(String id) {
		fileRepository.delete(id);
	}

	@Override
	public File getFileById(String id) {
		return fileRepository.findOne(id);
	}

	@Override
	public List<File> listFilesByPage(int pageIndex, int pageSize) {
		Page<File> page = null;
		List<File> list = null;

		Sort sort = new Sort(Direction.DESC, "uploadDate");
		Pageable pageable = new PageRequest(pageIndex, pageSize, sort);

		page = fileRepository.findAll(pageable);
		list = page.getContent();
		return list;
	}
}
