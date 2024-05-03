# Loop Bank Application

This repository contains the implementation of a banking services. The service includes functionalities for user account management, transaction processing, and email notifications.

## Overview

The service is designed to handle various banking operations such as account creation, balance enquiry, account credit, account debit, and inter-account transfers. It also includes the generation of bank statements and sending them via email.

## Key Components

- **User Management**: Handles user account creation, balance enquiries, and name enquiries.
- **Transaction Processing**: Manages account credit, debit, and inter-account transfers.
- **Email Notifications**: Sends email alerts for account operations and bank statements.
- **Bank Statement Generation**: Generates PDF bank statements for a given account number and date range.

## Dependencies

- Spring Boot
- Spring Mail for email notifications
- iText for PDF generation

## Usage

1. **Account Creation**: Use the `createAccount` method to create a new user account.
2. **Balance Enquiry**: Use the `balanceEnquiry` method to check the balance of an account.
3. **Account Credit**: Use the `creditAccount` method to credit an account.
4. **Account Debit**: Use the `debitAccount` method to debit an account.
5. **Inter-Account Transfer**: Use the `transfer` method to transfer funds between accounts.
6. **Generate Bank Statement**: Use the `generateStatement` method to generate a bank statement for a specific account.

## Contributing

Contributions are welcome. Please feel free to submit a pull request.

## License

This project is licensed under the MIT License.
