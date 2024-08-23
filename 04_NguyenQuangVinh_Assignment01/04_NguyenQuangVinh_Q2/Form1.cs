using _04_NguyenQuangVinh_Q2.Models;
using Microsoft.IdentityModel.Tokens;

namespace _04_NguyenQuangVinh_Q2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            LoadData();

        }

        private void LoadData()
        {
            using (PE_Fall21B5Context context = new PE_Fall21B5Context())
            {
                var data = (from e in context.Employees
                            select new
                            {
                                ID = e.Id,
                                Name = e.Name,
                                Sex = e.Sex,
                                Dob = e.Dob,
                                Position = e.Position,
                            }).ToList();
                dgvData.DataSource = data;
            }
        }

        private void dgvData_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1)
            {
                return;
            }
            txtID.Text = dgvData.Rows[e.RowIndex].Cells[0].FormattedValue.ToString();
            txtName.Text = dgvData.Rows[e.RowIndex].Cells[1].FormattedValue.ToString();

            if (dgvData.Rows[e.RowIndex].Cells[3].FormattedValue.ToString().Equals("Male"))
            {
                rbtnMale.Checked = true;
                rbtnFemale.Checked = false;
            }
            else
            {
                rbtnMale.Checked = false;
                rbtnFemale.Checked = true;
            }

            string position = dgvData.Rows[e.RowIndex].Cells[4].FormattedValue.ToString();
            if (position.Equals("Developer"))
            {
                cbPosition.SelectedIndex = 1;
            }
            else if
                (position.Equals("Leader"))
            {
                cbPosition.SelectedIndex = 2;
            }
            else if
                (position.Equals("Tester"))
            {
                cbPosition.SelectedIndex = 3;
            }
            else
            {
                cbPosition.SelectedIndex = 4;
            }
        }

        private void btnRefresh_Click(object sender, EventArgs e)
        {
            txtID.Text = "";
            txtName.Text = "";
            rbtnMale.Checked = true;
            rbtnFemale.Checked = false;
            cbPosition.SelectedIndex = 0;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            string sex;
            string position;
            using (PE_Fall21B5Context context = new PE_Fall21B5Context())
            {

                if (rbtnMale.Checked = true)
                {
                    sex = "Male";
                }
                else
                {
                    sex = "Female";

                }
                if (cbPosition.SelectedIndex == 1)
                {
                    position="Developer";
                }
                else if (cbPosition.SelectedIndex == 2)
                {
                    position = "Leader";
                }
                else if (cbPosition.SelectedIndex == 3)
                {
                    position = "Tester";
                }
                else
                {
                    position = "Manager";
                }
                //tao ra 1 doi tuong de add
                Employee p = new Employee()
                {
                    Name = txtName.Text,
                    Dob = dtimeDOB.Value,
                    Sex = sex,
                    Position = position,
                };
                //sau do add vao Db
                context.Employees.Add(p);
                if (context.SaveChanges() > 0)
                {
                    MessageBox.Show("Add success");
                }
                else
                {
                    MessageBox.Show("Add fail");
                }
                LoadData();
            }
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            string sex, position;
            if (rbtnMale.Checked = true)
            {
                sex = "Male";
            }
            else
            {
                sex = "Female";

            }
            if (cbPosition.SelectedIndex == 1)
            {
                position = "Developer";
            }
            else if (cbPosition.SelectedIndex == 2)
            {
                position = "Leader";
            }
            else if (cbPosition.SelectedIndex == 3)
            {
                position = "Tester";
            }
            else
            {
                position = "Manager";
            }
            using (PE_Fall21B5Context context = new PE_Fall21B5Context())
            {
                //tim xem co doi tuong can update khong
                //tao ra mot product
                Employee p = context.Employees.FirstOrDefault(p => p.Id == Int32.Parse(txtID.Text));
                if (p != null)
                {
                    //update
                    p.Name = txtName.Text;
                    p.Sex = sex;
                    p.Dob = dtimeDOB.Value;
                    p.Position = position;
                    if (context.SaveChanges() > 0)
                    {
                        MessageBox.Show("Update success");
                    }
                    else
                    {
                        MessageBox.Show("Update fail");
                    }
                }
                else
                {
                    MessageBox.Show("Not found");
                }
                LoadData();

            }
        }
    }
}
