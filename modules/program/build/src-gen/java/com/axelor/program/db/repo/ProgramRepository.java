package com.axelor.program.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.db.Query;
import com.axelor.program.db.Program;

public class ProgramRepository extends JpaRepository<Program> {

	public ProgramRepository() {
		super(Program.class);
	}

	public Program findByName(String name) {
		return Query.of(Program.class)
				.filter("self.name = :name")
				.bind("name", name)
				.fetchOne();
	}

}

