using Microsoft.EntityFrameworkCore.Diagnostics;
using System.Data;
using System.Runtime.Intrinsics.Arm;
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
                while (dr.Read())
                {
                    Employee employee = new Employee()
                    {
                        Id = dr.GetInt32(0),
                        Name = dr.GetString(1),
                        Dob = dr.GetDateTime(2),
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
                while (dr.Read())
                {
                    Employee employee = new Employee()
                    {
                        Id = dr.GetInt32(0),
                        Name = dr.GetString(1),
                        Dob = dr.GetDateTime(2),
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
            }else if
                (position.Equals("Leader"))
            {
                cbPosition.SelectedIndex = 2;
            }else if
                (position.Equals("Tester"))
            {
                cbPosition.SelectedIndex = 3;
            }
            else
            {
                cbPosition.SelectedIndex = 4;
            }
        }
    }
}

