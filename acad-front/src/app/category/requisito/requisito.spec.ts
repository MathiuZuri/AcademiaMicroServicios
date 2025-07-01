import { ComponentFixture, TestBed } from '@angular/core/testing';
import {Requisito} from './requisito';

describe('RequisitoModel', () => {
  let component: Requisito;
  let fixture: ComponentFixture<Requisito>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Requisito] // standalone component
    }).compileComponents();

    fixture = TestBed.createComponent(Requisito);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
