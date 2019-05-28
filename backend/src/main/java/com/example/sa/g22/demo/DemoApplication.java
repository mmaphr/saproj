package com.example.sa.g22.demo;

import com.example.sa.g22.demo.Entity.*;
import com.example.sa.g22.demo.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@Bean
	ApplicationRunner init(UserRepository userRepository, ProposalRepository proposalRepository, ShippingRepository shippingRepository, ShippingStatusRepository shippingStatusRepository, ProvinceRepository provinceRepository) {
		return args -> {
			Stream.of("SomA", "SomB", "SomC").forEach(userName -> {
				userRepository.save(new User(userName));
			});
			userRepository.findAll().forEach(System.out::println);

			Stream.of("กระบี่","กรุงเทพมหานคร","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา" ,"ชลบุรี","ชัยนาท","ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา" ,"นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บุรีรัมย์","บึงกาฬ","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี" ,"พะเยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน" ,"ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา" ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี" ,"สุรินทร์","หนองคาย","หนองบัวลำภู","อยุธยา","อ่างทอง","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี").forEach(Provincename -> {
				provinceRepository.save(new Province(Provincename));
			});
			provinceRepository.findAll().forEach(System.out::println);

			Stream.of("จัดส่งสินค้าแล้วอยู่ระหว่างการขนย้าย", "ได้รับสิ้นค้าแล้ว").forEach(shippingStatusName -> {
                shippingStatusRepository.save(new ShippingStatus(shippingStatusName));
			});
			shippingStatusRepository.findAll().forEach(System.out::println);

			proposalRepository.save(new Proposal(userRepository.findById(1).getUsername(),"นาฬิกา",userRepository.findById(2).getUsername(),"เคสโทรศัพท์","จัดส่ง",userRepository.findById(1)));
			proposalRepository.save(new Proposal(userRepository.findById(2).getUsername(),"แหวน",userRepository.findById(3).getUsername(),"ตุ้มหู","จัดส่ง",userRepository.findById(2)));
			proposalRepository.save(new Proposal(userRepository.findById(3).getUsername(),"ไอโฟน",userRepository.findById(1).getUsername(),"ซัมซุง","จัดส่ง",userRepository.findById(3)));
			proposalRepository.findAll().forEach(System.out::println);

			Date D = new Date((2018-1900),(2-1),3);
			Date D1 = new Date((2018-1900),(3-1),27);
			Date D2 = new Date((2018-1900),(4-1),13);

			shippingRepository.save(new Shipping(proposalRepository.findById(1).getUserOffer(),proposalRepository.findById(1).getUserReceiver(),D1,"123/7","40000","EVS0123451234","ปณ.ขอนแก่น",shippingStatusRepository.findById(1),provinceRepository.findById(6),proposalRepository.findById(2)));
			shippingRepository.save(new Shipping(proposalRepository.findById(2).getUserOffer(),proposalRepository.findById(2).getUserReceiver(),D1,"123/7","40000","EVS0123451234","ปณ.ขอนแก่น",shippingStatusRepository.findById(1),provinceRepository.findById(6),proposalRepository.findById(2)));
			shippingRepository.save(new Shipping(proposalRepository.findById(3).getUserOffer(),proposalRepository.findById(3).getUserReceiver(),D2,"42/235","30000","EVS0123454321","ปณ.นครราชสีมา",shippingStatusRepository.findById(1),provinceRepository.findById(21),proposalRepository.findById(3)));
			shippingRepository.findAll().forEach(System.out::println);
		};


	}


}
