using Q1.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Q1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private readonly PE_PRN221Context context;
        public MainWindow()
        {
            context = new PE_PRN221Context();
            InitializeComponent();
            LoadData();
        }

        private void LoadData()
        {
            List<Department> list = context.Departments.ToList();
            foreach (Department department in list)
            {
                cbDepartment.Items.Add(department.DepartmentName);
            }
            cbDepartment.SelectedIndex = 0;
            List<Employee> employeeList = context.Employees.ToList();
            foreach (Employee employee in employeeList)
            {
                cbPosition.Items.Add(employee.Position);
            }
            cbPosition.SelectedIndex = 0;
            List<Skill> SkillList = context.Skills.ToList();
            foreach (Skill skill in SkillList)
            {
                lboxSkill.Items.Add(skill.SkillName);
            }
        }

        private void btnAdd_Click(object sender, RoutedEventArgs e)
        {
            /*MessageBox.Show(cbDepartment.SelectedIndex.ToString());*/

            if(txtName.Text.Length < 3)
            {
                MessageBox.Show("Employee's name must more than 3 characters");
                return;
            }
            if (dpHireDate.SelectedDate <= DateTime.Now)
            {
                MessageBox.Show("The employee's hire date must be before the current date");
                return;

            }
            if (dpDob.SelectedDate >= DateTime.Now)
            {
                MessageBox.Show("The employee's Dob date must be before the current date");
                return;

            }
            if (lboxSkill.SelectedItem == null)
            {
                MessageBoxResult result = MessageBox.Show("Confirm", "You have not selected any skill. Do you want to add an employee without adding them to any skill?", MessageBoxButton.YesNo, MessageBoxImage.Question);
                if (result == MessageBoxResult.Yes)
                {
                    AddEmployee(result == MessageBoxResult.Yes);
                }
            }
            else
            {
                AddEmployee(true);
            }
        }
        private void AddEmployee(bool skill)
        {

            string prosition;
            if (string.IsNullOrEmpty(txtName.Text))
            {
                MessageBox.Show("Name not null");
                return;
            }
            Employee employee = new Employee()
            {
                Name = txtName.Text,
                Dob = (dpDob.DisplayDate),
                DepartmentId = cbDepartment.SelectedIndex,
                Position = cbPosition.SelectedValue.ToString(),
                HireDate = dpHireDate.DisplayDate,
            };
            context.Employees.Add(employee);
            context.SaveChanges();
            LoadData();
            MessageBox.Show("Adding successful!");
        }

        private void cboxIsManager_Checked(object sender, RoutedEventArgs e)
        {

        }
    }
}
