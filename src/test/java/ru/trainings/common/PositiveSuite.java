package ru.trainings.common;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import ru.trainings.tests.TestClass;


@SuiteClasses({
	 TestClass.class
	})
	@RunWith(Categories.class)
	@IncludeCategory(MyCategories.PositiveTests.class)
	public class PositiveSuite {

	}
