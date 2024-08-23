using Microsoft.EntityFrameworkCore.Diagnostics;
using Microsoft.EntityFrameworkCore.Internal;
using System.Data;
using System.Runtime.Intrinsics.Arm;
using System.Text.RegularExpressions;
using WinForms_ADO;

namespace _04_NguyenQuangVinh_Q1
{
    public partial class Form1 : Form
    {
        DataProvider dp = new DataProvider();
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
            GetDepartment();
            List<Employee> list = new List<Employee>();
            String strSQL = "SELECT  [Employee].[Id]" +
                ",[Employee].[Name]" +
                ",[Dob]" +
                ",[Sex]" +
                ",[Position]" +
                ",[Department]" +
                ",[Department].Name " +
                " FROM [PE_Fall21B5].[dbo].[Employee]" +
                " INNER JOIN [PE_Fall21B5].[dbo].[Department]" +
                "  ON Employee.Department = Department.Id";

            using (IDataReader dr = dp.executeQuery2(strSQL))
            {
                string formattedDob;
                while (dr.Read())
                {
                    DateTime dob = dr.GetDateTime(2);
                    formattedDob = dob.ToString("dd/MM/yy");
                    Employee employee = new Employee()
                    {
                        Id = dr.GetInt32(0),
                        Name = dr.GetString(1),
                        Dob = formattedDob,
                        Sex = dr.GetString(3),
                        Position = dr.GetString(4),
                        Department = dr.GetInt32(5),
                        DepartmentName = dr.GetString(6),

                    };
                    list.Add(employee);

                }
            }
            List<Employee> listFilter = new List<Employee>();
            if (rbtnFemale.Checked == true)
            {
                foreach (Employee emp in list)
                {
                    if (emp.Sex.Equals("Female"))
                    {
                        listFilter.Add(emp);
                    }
                }
                dgvData.DataSource = listFilter;
            }
            if (rbtnMale.Checked == true)
            {
                foreach (Employee emp in list)
                {
                    if (emp.Sex.Equals("Male"))
                    {
                        listFilter.Add(emp);
                    }
                }
                dgvData.DataSource = listFilter;
            }
            if (rbtnMaleOrFemale.Checked == true)
            {
                dgvData.DataSource = null;
                dgvData.DataSource = list;
            }
            if (cbPosition.SelectedIndex > 0)
            {
                foreach (Employee emp in list)
                {

                    if (emp.Position.Equals(cbPosition.SelectedItem.ToString()))
                    {
                        listFilter.Add(emp);
                    }
                }
                dgvData.DataSource = listFilter;
            }
            else
            {
                cbPosition.SelectedIndex = 0;
            }
            if(txtName.Text.Length > 0)
            {
                listFilter.Clear();
                foreach (Employee emp in list)
                {
                    if (emp.Name.Contains(txtName.Text))
                    {
                        listFilter.Add(emp);
                    }
                }
                dgvData.DataSource = null;
                dgvData.DataSource = listFilter;
            }
            else
            {
                foreach (Employee emp in list)
                {
                    listFilter.Add(emp);
                }
                dgvData.DataSource = listFilter;
            }

        }

        private void GetDepartment()
        {
            List<Employee> list = new List<Employee>();
            String strSQL = "SELECT  [Employee].[Id]" +
                ",[Employee].[Name]" +
                ",[Dob]" +
                ",[Sex]" +
                ",[Position]" +
                ",[Department]" +
                ",[Department].Name " +
                " FROM [PE_Fall21B5].[dbo].[Employee]" +
                " INNER JOIN [PE_Fall21B5].[dbo].[Department]" +
                "  ON Employee.Department = Department.Id";
            using (IDataReader dr = dp.executeQuery2(strSQL))
            {
                string formattedDob;
                while (dr.Read())
                {
                    DateTime dob = dr.GetDateTime(2);
                    formattedDob = dob.ToString("dd/MM/yy");
                    Employee employee = new Employee()
                    {
                        Id = dr.GetInt32(0),
                        Name = dr.GetString(1),
                        Dob = formattedDob,
                        Sex = dr.GetString(3),
                        Position = dr.GetString(4),
                        Department = dr.GetInt32(5),
                        DepartmentName = dr.GetString(6),

                    };
                    list.Add(employee);

                }
            }
            dgvData.DataSource = list;
        }
        static bool ValidateName(string name)
        {

            string pattern = @"^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";

            return Regex.IsMatch(name, pattern);
        }
        private void dgvData_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1)
            {
                return;
            }

            txtName.Text = dgvData.Rows[e.RowIndex].Cells[1].FormattedValue.ToString();
            if (dgvData.Rows[e.RowIndex].Cells[3].FormattedValue.ToString().Equals("Male"))
            {
                rbtnMale.Checked = true;
                rbtnFemale.Checked = false;
                rbtnMaleOrFemale.Checked = false;
            }
            else if (dgvData.Rows[e.RowIndex].Cells[3].FormattedValue.ToString().Equals("Female"))
            {
                rbtnMale.Checked = false;
                rbtnFemale.Checked = true;
                rbtnMaleOrFemale.Checked = false;
            }
            else
            {
                rbtnMale.Checked = false;
                rbtnFemale.Checked = false;
                rbtnMaleOrFemale.Checked = true;
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

        private void rbtnFemale_CheckedChanged(object sender, EventArgs e)
        {
            LoadData();
        }

        private void rbtnMaleOrFemale_CheckedChanged(object sender, EventArgs e)
        {
            LoadData();
        }

        private void rbtnMale_CheckedChanged(object sender, EventArgs e)
        {
            LoadData();
        }

        private void cbPosition_SelectedIndexChanged(object sender, EventArgs e)
        {
           
            LoadData();
        }

        private void txtName_TextChanged(object sender, EventArgs e)
        {
            LoadData();
        }
    }
}

