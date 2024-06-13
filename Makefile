SRC_DIR = src
MAIN_CLASS = Main
JAVAC = javac
JAVA = java

run:
	@rm -rf $(SRC_DIR)/**/*.class
	$(JAVAC) $(SRC_DIR)/$(MAIN_CLASS).java
	$(JAVA) $(SRC_DIR)/$(MAIN_CLASS)

clear:
	@rm -rf $(SRC_DIR)/*.class
