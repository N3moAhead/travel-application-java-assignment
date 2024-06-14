SRC_DIR = src
MAIN_CLASS = Main
JAVAC = javac
JAVA = java

run:
	@find $(SRC_DIR) -name "*.class" -type f -delete
	$(JAVAC) $(SRC_DIR)/$(MAIN_CLASS).java
	$(JAVA) $(SRC_DIR)/$(MAIN_CLASS)

clear:
	@find $(SRC_DIR) -name "*.class" -type f -delete
