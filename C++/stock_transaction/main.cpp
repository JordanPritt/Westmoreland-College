#include <iostream>
using namespace std;

//declaring the variables

const double purchased_shares = 1000;
const double sold_shares = 1000;
const double comission = 0.02;
const double price_purchase = 45.50;
const double price_sold = 56.90;

int main() {

    //doing the math...oh boy :|

    double purchase_total = purchased_shares * price_purchase;
    double sale_total = sold_shares * price_sold;
    double comission_paid = purchase_total * comission + sale_total * comission;

    //displaying results

    std::cout << "Joe paid "<< purchase_total
    << " dollars for his initial purchase." << std::endl;

    std::cout << "Joe paid his broker " << purchase_total * comission
    << " dollars for his initial purchase." << std::endl;

    std::cout << "Joe sold his initial stock purchase for "
    << sold_shares * price_sold << " dollars." << std::endl;

    std::cout << "Joe paid his broker " << sold_shares * price_sold * comission
    << " dollars after selling his initial purchase." << std::endl;

    std::cout << "Joe made a total of " << sold_shares * price_sold - purchase_total - comission_paid
    << " dollars after buy, selling, and paying his broker." << std::endl;

    //bringing this to the ending
    return 0;
}