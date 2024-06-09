# Variablen für Pfade
SRC_DIR = src
BIN_DIR = bin
MAIN_CLASS = Main
JAVAC = javac
JAVA = java

run:
	@mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $(SRC_DIR)/$(MAIN_CLASS).java
	$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)

clear:
	@echo "Bereinige kompilierte Dateien..."
	@rm -rf $(BIN_DIR)
	@echo "Bereinigung abgeschlossen."
