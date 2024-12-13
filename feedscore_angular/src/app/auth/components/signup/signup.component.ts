import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss'
})
export class SignupComponent {

  signUpForm!: FormGroup;
  hidePassword = true;
  hidePassword1 = true;

  securityQuestions = [
    { value: 'birthCity', viewValue: 'What city were you born in?' },
    { value: 'childhoodNickname', viewValue: 'What was your childhood nickname?' },
    { value: 'bestFriend', viewValue: 'Who is your best friend?' },
  ];

  constructor(private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private authService: AuthService,
    private router: Router) {
      this.signUpForm = this.fb.group({
        name: [null, [Validators.required]],
        email: [null, [Validators.required, Validators.email]],
        mobile: [null, [Validators.required,  Validators.pattern('^\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$')]],
        password: [null, [Validators.required, Validators.pattern(/^.{8,}$/)]],
        confirmPassword: [null, [Validators.required]],
        securityQuestion1: ['', Validators.required],
      securityAnswer1: ['', Validators.required],
      securityQuestion2: ['', Validators.required],
      securityAnswer2: ['', Validators.required],
      securityQuestion3: ['', Validators.required],
      securityAnswer3: ['', Validators.required],
      }
      )
  }
  selectedQuestions: string[] = [];
  onQuestionChange(question: string, controlName: string) {
    const selectedValue = this.signUpForm.get(controlName)?.value;
    if (selectedValue) {
      this.selectedQuestions.push(selectedValue);
    }
  }

  ngOnInit() {
    
  }

  togglePasswordVisibility(){
    this.hidePassword=!this.hidePassword;
  }
  
  togglePasswordVisibility1(){
    this.hidePassword1=!this.hidePassword1;
  }



  onSubmit(){
    console.log(this.signUpForm.value);

    const password=this.signUpForm.get('password')?.value;
    const confirmPassword=this.signUpForm.get('confirmPassword')?.value;

    if(password !== confirmPassword){
      this.snackBar.open('Passwords do not match','close',{duration:5000, panelClass: 'error-snackbar'});
      return;
    }

    this.authService.signup(this.signUpForm.value).subscribe((response) => {
      if(response.id != null){
      this.snackBar.open('Sign up successful!','close',{duration:5000});
      this.router.navigateByUrl("/login");
      }
      else{
        this.snackBar.open('Sign up failed. Please try again','close',{duration:5000, panelClass: 'error-snackbar'});
      }
    },
    );
  }

}
