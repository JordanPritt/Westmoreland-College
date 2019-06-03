#include <iostream>
#include <fstream>

namespace config_reader {

std::ifstream file("config.txt");
    if(file.is_open()) {

        std::string userinfo[4];

        for (int i = 0; i < 4; ++i) {
            file >> userinfo[i];
        }
    }
    
    else {
        std::cout << "File didn't open :(" <<std::endl;
	}
}
