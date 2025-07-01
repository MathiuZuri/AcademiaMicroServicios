import { ComponentFixture, TestBed } from '@angular/core/testing';
import {Matricula} from './matricula';

describe('MatriculaModel', () => {
  let component: Matricula;
  let fixture: ComponentFixture<Matricula>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Matricula] // standalone component
    }).compileComponents();

    fixture = TestBed.createComponent(Matricula);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
