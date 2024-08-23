using ProjectPRMAPI.Models;
using System.Net.Mail;
using System.Net;
using System;

namespace ProjectPRMAPI.Services
{
    public class UserService
    {
        private List<User> _users = new List<User>();
        private int _nextUserId = 1;
        private int _nextTransactionId = 1;
        private int _nextBetId = 1;
        public UserService()
        {
            GenerateRandomData(10, 2);
        }

        private void GenerateRandomData(int numberOfUsers, int transactionsPerUser)
        {
            var random = new Random();

            for (int i = 0; i < numberOfUsers; i++)
            {
                String un = RandomString(8);
                var user = new User
                {
                    Id = _nextUserId++,
                    Name = $" {un+ i + 1}",
                    Email = $"{un+ i + 1}@example.com",
                    Password = RandomString(10),
                    IsEmailVerified = true 
                };

                _users.Add(user);

                // Tạo ngẫu nhiên các giao dịch cho mỗi người dùng
                for (int j = 0; j < transactionsPerUser; j++)
                {
                    var transaction = new Transaction
                    {
                        Id = _nextTransactionId++,
                        UserId = user.Id,
                        Date = DateTime.Now.AddDays(-random.Next(1, 30)), // Ngày giờ ngẫu nhiên gần đây
                        Type = random.Next(2) == 0 ? "Deposit" : "Withdrawal", // Loại giao dịch ngẫu nhiên
                        AccountNumber = $"ACC{random.Next(1000, 9999)}", // Số tài khoản ngẫu nhiên
                        AccountName = user.Name, // Tên tài khoản là tên của người dùng
                        Amount = random.Next(100, 10000), // Số tiền ngẫu nhiên
                        Bank = "Some Bank", // Tên ngân hàng cố định
                        Status = "pending"
                    };
                    user.Transactions.Add(transaction);

                    var bet = new Bet
                    {
                        Id = _nextTransactionId++,
                        MatchId = "1",
                        bet = random.Next(100, 10000),
                        betValue = random.Next(2) == 0 ? true : false,
                    };
                    user.Bets.Add(bet);
                }
            }
        }

        private string RandomString(int length)
        {
            const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            var random = new Random();
            return new string(Enumerable.Repeat(chars, length)
              .Select(s => s[random.Next(s.Length)]).ToArray());
        }

        public void AddBet(int userId, string MatchBetId, string accountNumber, string accountName, decimal amountBet, string bank)
        {
            var user = _users.FirstOrDefault(u => u.Id == userId);
            if (user == null)
            {
                throw new Exception("User not found");
            }

            var bet = new Bet
            {
                Id = _nextTransactionId++,
                MatchId = MatchBetId,
                bet = amountBet,
                betValue = false,
            };
            user.Bets.Add(bet);
        }
        public List<User> GetAllUsers()
        {
            return _users;
        }
        public User Register(string name, string email, string password)
        {
            if (_users.Any(u => u.Email.Equals(email, StringComparison.OrdinalIgnoreCase)))
            {
                throw new Exception("Email already exists");
            }

            var user = new User
            {
                Id = _nextUserId++,
                Name = name,
                Email = email,
                Password = password,
                IsEmailVerified = false
            };

            _users.Add(user);
            return user;
        }

        public User Login(string email, string password)
        {
            var user = _users.FirstOrDefault(u => u.Email.Equals(email, StringComparison.OrdinalIgnoreCase) && u.Password == password);
            if (user == null)
            {
                throw new Exception("Invalid email or password");
            }

            return user;
        }

        public void SendVerificationEmail(int userId)
        {
            var user = _users.FirstOrDefault(u => u.Id == userId);
            if (user == null)
            {
                throw new Exception("User not found");
            }

            var random = new Random();
            var verificationCode = random.Next(100000, 999999).ToString();
            user.VerificationCode = verificationCode;
            user.VerificationCodeExpiry = DateTime.Now.AddMinutes(10); // Mã xác nhận có hiệu lực trong 10 phút.

            // Gửi email với mã xác nhận
            SendEmail(user.Email, "Email Verification", $"Your verification code is {verificationCode}");
        }

        public bool VerifyEmail(int userId, string verificationCode)
        {
            var user = _users.FirstOrDefault(u => u.Id == userId);
            if (user == null || user.VerificationCodeExpiry < DateTime.Now)
            {
                return false;
            }

            if (user.VerificationCode == verificationCode)
            {
                user.IsEmailVerified = true;
                user.VerificationCode = null;
                user.VerificationCodeExpiry = null;
                return true;
            }

            return false;
        }

        private void SendEmail(string to, string subject, string body)
        {
            var fromAddress = new MailAddress("Vietanh100102@gmail.com", "NoLanOnline");
            var toAddress = new MailAddress(to);
            const string fromPassword = "Anhdhvhe161143."; // Nên bảo mật phần này

            var smtp = new SmtpClient
            {
                Host = "smtp.office365.com",
                Port = 587,
                EnableSsl = true,
                DeliveryMethod = SmtpDeliveryMethod.Network,
                UseDefaultCredentials = false,
                Credentials = new NetworkCredential(fromAddress.Address, fromPassword)
            };

            using (var message = new MailMessage(fromAddress, toAddress)
            {
                Subject = subject,
                Body = body
            })
            {
                smtp.Send(message);
            }
        }

        public void AddTransaction(int userId, string type, string accountNumber, string accountName, decimal amount, string bank)
        {
            var user = _users.FirstOrDefault(u => u.Id == userId);
            if (user == null)
            {
                throw new Exception("User not found");
            }

            var transaction = new Transaction
            {
                Id = _nextTransactionId++,
                UserId = userId,
                Date = DateTime.Now,
                Type = type,
                AccountNumber = accountNumber,
                AccountName = accountName,
                Amount = amount,
                Bank = bank,
                Status= "pending",
            };
            user.Transactions.Add(transaction);
        }

        public List<Transaction> GetTransactionHistory(int userId)
        {
            var user = _users.FirstOrDefault(u => u.Id == userId);
            if (user == null)
            {
                throw new Exception("User not found");
            }

            return user.Transactions;
        }

        public Boolean ChangeTransactionStatus(int userId, int TransactionId, string newStatus)
        {
            var user = _users.FirstOrDefault(u => u.Id == userId);
            if (user == null)
            {
                throw new Exception("User not found");
            }
            var transaction = user.Transactions.FirstOrDefault(u => u.Id == TransactionId);
            if (transaction == null)
            {
                throw new Exception("Transaction not found");
            }
            if(transaction.Status.Equals("Accept", StringComparison.OrdinalIgnoreCase))
            {
                throw new Exception("This transaction had been processed");
            }
            if (newStatus.Equals("Accept", StringComparison.OrdinalIgnoreCase)) {
                if (transaction.Type.Equals("Deposit", StringComparison.OrdinalIgnoreCase))
                {
                    user.balance = user.balance + transaction.Amount;
                }
                else
                {
                    if (user.balance < transaction.Amount)
                    {
                        throw new Exception("Your balance is not enough money");
                    }
                    user.balance = user.balance - transaction.Amount;
                }
            }
            transaction.Status = newStatus;
            return true;
        }

        public User GetUserByEmail(string email)
        {
            return _users.FirstOrDefault(u => u.Email.Equals(email, StringComparison.OrdinalIgnoreCase));
        }

        public bool RequestPasswordReset(string email)
        {
            var user = _users.FirstOrDefault(u => u.Email.Equals(email, StringComparison.OrdinalIgnoreCase));
            if (user == null)
            {
                throw new Exception("User not found");
            }

            var random = new Random();
            var resetCode = random.Next(100000, 999999).ToString();
            user.VerificationCode = resetCode;
            user.VerificationCodeExpiry = DateTime.Now.AddMinutes(10); // Mã reset có hiệu lực trong 10 phút.

            // Gửi email với mã reset
            SendEmail(user.Email, "Password Reset Code", $"Your password reset code is {resetCode}");

            return true;
        }

        public bool VerifyPasswordResetCode(string email, string resetCode)
        {
            var user = _users.FirstOrDefault(u => u.Email.Equals(email, StringComparison.OrdinalIgnoreCase));
            if (user == null || user.VerificationCodeExpiry < DateTime.Now)
            {
                return false;
            }

            if (user.VerificationCode == resetCode)
            {
                user.VerificationCode = null;
                user.VerificationCodeExpiry = null;
                return true;
            }

            return false;
        }

        public bool ChangePassword(string email, string newPassword)
        {
            var user = _users.FirstOrDefault(u => u.Email.Equals(email, StringComparison.OrdinalIgnoreCase));
            if (user == null)
            {
                throw new Exception("User not found");
            }

            user.Password = newPassword;

            user.VerificationCode = null;
            user.VerificationCodeExpiry = null;
            return true;
        }
    }
}
