#include <iostream>
#include <fstream>

using namespace std;

bool generate_config()
{
  ofstream file;
  string name, email, password, time;

  try
  {
    // open or create config file
    file.open("app.config");

    //receive user input
    cout << "What is your full name? " << endl;
    getline(cin, name);
    cout << "What is your email address? " << endl;
    getline(cin, email);
    cout << "what is your password? " << endl;
    getline(cin, password);
    cout << "What timezone do you live in?" << endl;
    getline(cin, time);

    //write answers to config file.
    file << "[user]" << endl;
    file << "\tname = " + name << endl;
    file << "\temail = " + email << endl;
    file << "\tpassword = " + password << endl;
    file << "\ttimezone = " + time << endl;

    //close file
    file.close();

    return true;
  }
  catch (const std::exception &e)
  {
    return false;
  }
}

void update_option(string option, string value)
{
  bool option_found = false;
  string temp, name, email, password, time;
  fstream file;

  file.open("app.config", ios::in | ios::out);

  while (file >> temp)
  {
    cout << temp << endl;

    if (temp.find("[user]") != std::string::npos)
    {
    }
    else if (temp.find("name") != std::string::npos)
    {
      name = value;
    }
    else if (temp.find("email") != std::string::npos)
    {
      email = value;
    }
    else if (temp.find("password") != std::string::npos)
    {
      password = value;
    }
    else if (temp.find("time") != std::string::npos)
    {
      time = value;
    }
  }

  file << "[user]" << endl;
  file << "\tname = " + name << endl;
  file << "\temail = " + email << endl;
  file << "\tpassword = " + password << endl;
  file << "\ttimezone = " + time << endl;

  file.close();
}

bool edit_config(string field)
{
  string name, email, password, time;

  if (field == "name")
  {
    cout << "What would you like to change the name to? " << endl;
    getline(cin, name);
    update_option(field, name);
  }
  else if (field == "email")
  {
    cout << "What would you like to change the email to? " << endl;
    getline(cin, email);
    update_option(field, email);
  }
  else if (field == "password")
  {
    cout << "What would you like to change the password to? " << endl;
    getline(cin, password);
    update_option(field, password);
  }
  else if (field == "time")
  {
    cout << "What would you like to change the timezone to? " << endl;
    getline(cin, time);
    update_option(field, time);
  }

  cout << "Field [" + field + "] was changed!" << endl;

  return true;
}

int main(int argc, char *argv[])
{

  if (argc <= 1)
  {
    cout << "You must provide an option." << endl;
    return 0;
  }
  else if (static_cast<string>(argv[1]) == "init")
  {
    bool config = generate_config();
    if (config == true)
    {
      cout << "config file created!" << endl;
    }
  }
  else if (static_cast<string>(argv[1]) == "edit")
  {
    string field;

    cout << "Please enter option to edit" << endl;
    getline(cin, field);
    bool edit = edit_config(field);
  }
  return 0;
}